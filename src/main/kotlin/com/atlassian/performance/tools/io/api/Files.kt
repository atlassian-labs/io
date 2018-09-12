package com.atlassian.performance.tools.io.api

import java.io.File

fun dereference(
    systemProperty: String
): File {
    val file = File(System.getProperty(systemProperty))
    if (file.exists()) {
        return file
    } else {
        throw Exception("$systemProperty points to ${file.absolutePath}, but this file does not exist")
    }
}