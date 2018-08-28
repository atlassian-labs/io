package com.atlassian.performance.tools.io.api

/**
 * Read text from a classpath resource.
 *
 * @param resourcePath Points to the resource in absolute terms, e.g. `com/atlassian/performance/tools/io/some.xml`.
 * @return The contents of the resource.
 */
fun readResourceText(
    resourcePath: String
): String = ClassLoader.getSystemResourceAsStream(resourcePath)
    .bufferedReader()
    .use { it.readText() }
