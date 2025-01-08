import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.2"

project {

    vcsRoot(HttpsGithubComChubatovaTigerGradleTests)

    buildType(Build1)
}

object Build1 : BuildType({
    name = "build1"
})

object HttpsGithubComChubatovaTigerGradleTests : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/GradleTests"
    url = "https://github.com/ChubatovaTiger/GradleTests"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "ChubatovaTiger"
        password = "credentialsJSON:61d92677-39a4-4689-91b2-ea7788d4356d"
    }
})
