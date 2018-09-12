# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## API
The API consists of all public Kotlin types from `com.atlassian.performance.tools.io.api` and its subpackages:

  * [source compatibility]
  * [binary compatibility]
  * [behavioral compatibility] with behavioral contracts expressed via Javadoc

[source compatibility]: http://cr.openjdk.java.net/~darcy/OpenJdkDevGuide/OpenJdkDevelopersGuide.v0.777.html#source_compatibility
[binary compatibility]: http://cr.openjdk.java.net/~darcy/OpenJdkDevGuide/OpenJdkDevelopersGuide.v0.777.html#binary_compatibility
[behavioral compatibility]: http://cr.openjdk.java.net/~darcy/OpenJdkDevGuide/OpenJdkDevelopersGuide.v0.777.html#behavioral_compatibility

## [Unreleased]
[Unreleased]: https://bitbucket.org/atlassian/workspace/branches/compare/master%0Drelease-1.0.0

### Added
- Dereference system properties pointing to files.

## [1.0.0] - 2018-08-28
[1.0.0]: https://bitbucket.org/atlassian/io/branches/compare/release-1.0.0%0Drelease-0.0.1

### Changed
- Define the public API.

### Added
- License.
- Add this change log.

## [0.0.1] - 2018-07-30
[0.0.1]: https://bitbucket.org/atlassian/io/branches/compare/release-0.0.1%0Dinitial-commit

### Added
- Migrate the extra I/O layer from [JPT submodule].
- Add [README.md](README.md).
- Configure Bitbucket Pipelines.

[JPT submodule]: https://stash.atlassian.com/projects/JIRASERVER/repos/jira-performance-tests/browse/io?at=9cd6e75a139a632d37b99402005a73c1365a53be
