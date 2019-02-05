package com.atlassian.performance.tools.io.api

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.file.Files

class DirectoriesKtTest {

    @Test
    fun shouldCopyIntoDeepPath() {
        val deepPath = Files.createTempDirectory("deep-path-copy-test")
                .resolve("alpha")
                .resolve("beta")
                .resolve("gamma")

        streamData("some data").copy(deepPath)

        assertThat(deepPath).hasContent("some data")
    }

    @Test
    fun shouldCopyTwice() {
        val target = Files.createTempFile("repeated-copy-test", ".txt")

        streamData("first").copy(target)
        streamData("second").copy(target)

        assertThat(target).hasContent("second")
    }

    private fun streamData(
        data: String
    ): InputStream = ByteArrayInputStream(data.toByteArray())
}