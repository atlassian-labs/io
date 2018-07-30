package com.atlassian.performance.tools.io

fun readResourceText(
    resourcePath: String
) = ClassLoader.getSystemResourceAsStream(resourcePath)
    .bufferedReader()
    .use { it.readText() }
