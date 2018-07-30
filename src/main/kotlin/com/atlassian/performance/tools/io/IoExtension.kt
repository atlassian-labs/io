package com.atlassian.performance.tools.io

import java.io.File
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

fun InputStream.copy(
    target: Path
): Path {
    target.toFile().ensureDirectory()
    Files.copy(this, target, StandardCopyOption.REPLACE_EXISTING)
    return target
}

fun File.ensureParentDirectory() : File {
    parentFile.ensureDirectory()
    return this
}

fun File.ensureDirectory() : File {
    if (!this.isDirectory) {
        if (this.exists()) {
            throw RuntimeException("$this already exists and is not a directory")
        }
        val creationSuccessful = this.mkdirs()
        if (!creationSuccessful) {
            if (!this.isDirectory) {
                throw RuntimeException("Failed to ensure that $this is a directory")
            }
        }
    }
    return this
}

fun Path.ensureDirectory(): Path = toFile().ensureDirectory().toPath()

/**
 * Lists directories ordered consistently across platforms.
 */
fun File.directories(): List<File> = listFiles { file -> file.isDirectory }
    ?.toList()
    ?.sortedBy { it.absolutePath }
    ?: throw Exception("Cannot list directories from $this")

/**
 * Resolve path, even if [path] contains illegal filesystem characters.
 * Should work on ext4, APFS and NTFS.
 */
fun Path.resolveSafely(
    path: String
): Path = resolve(
    path.replace(oldValue = ":", newValue = "-")
)