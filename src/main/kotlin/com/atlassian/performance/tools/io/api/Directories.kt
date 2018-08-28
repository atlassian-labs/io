package com.atlassian.performance.tools.io.api

import java.io.File
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

/**
 * Make [this] a directory or throw.
 */
fun Path.ensureDirectory(): Path = toFile().ensureDirectory().toPath()

/**
 * Resolve path, even if [path] contains illegal filesystem characters.
 * Should work on ext4, APFS and NTFS.
 */
fun Path.resolveSafely(
    path: String
): Path = resolve(
    path.replace(oldValue = ":", newValue = "-")
)

/**
 * Make [this.parentFile] a directory or throw.
 */
fun File.ensureParentDirectory(): File {
    parentFile.ensureDirectory()
    return this
}

/**
 * Make [this] a directory or throw.
 */
fun File.ensureDirectory(): File {
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

/**
 * List directories ordered consistently across platforms.
 */
fun File.directories(): List<File> = listFiles { file -> file.isDirectory }
    ?.toList()
    ?.sortedBy { it.absolutePath }
    ?: throw Exception("Cannot list directories from $this")

/**
 * Copy the contents of [this] to [target], even if [target] doesn't exist yet.
 */
fun InputStream.copy(
    target: Path
): Path {
    target.toFile().ensureDirectory()
    Files.copy(this, target, StandardCopyOption.REPLACE_EXISTING)
    return target
}
