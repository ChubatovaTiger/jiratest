import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

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

version = "2026.1"

project {

    buildType(Comp)
    buildType(Dep)
    buildType(Build2)

    params {
        param("p", "p")
        param("a", "1")
    }

    pipeline(Ppl3)
}

object Build2 : BuildType({
    name = "Build2a"

    vcs {
        root(AbsoluteId("ChubatovaSilent2_Subproject2Silent2_HttpsGithubComChubatovaTiger48974refsHeadsMaster"))
    }
})

object Comp : BuildType({
    name = "comp"

    type = BuildTypeSettings.Type.COMPOSITE

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }

    dependencies {
        snapshot(Dep) {
        }
    }
})

object Dep : BuildType({
    name = "dep"

    vcs {
        root(DslContext.settingsRoot)
    }
})


object Ppl3 : Pipeline({
    name = "ppl3"

    repositories {
        repository(AbsoluteId("ChubatovaSilent2_Subproject2Silent2_HttpsGithubComChubatovaTiger48974refsHeadsMaster"))
    }

    triggers {
        vcs {
            enabled = false
        }
    }

    job(Ppl3_Job1)
    job(Ppl3_Job2)
})

object Ppl3_Job1 : Job({
    id("Job1")
    name = "Job 5a"
})

object Ppl3_Job2 : Job({
    id("Job2")
    name = "Job 2"

    dependency(Ppl3_Job1)
})
