# gdx-webgpu-app

A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers and an `ApplicationAdapter` extension that draws libGDX logo.

Make sure to specify Java version 11 in gdx-liftoff.

# Update gradle.properties

Add a version for gdx-webgpu and for gdx-teavm.  The versions for gdx and for teaVM can be commented out or removed:

```
    gdxWebGPUVersion=0.3
    gdxTeaVMVersion=1.3.0
```

Note that gdx-teavm needs to be at least 1.3.0.

# Update TeaVMBuilder

There has been a breaking API change in gdx-teaVM since 1.2.1: TeaBuilder.config() no longer returns a TeaVMTool.
Therefore, change the following in TeaVMBuilder.java:

```     //TeaVMTool tool = TeaBuilder.config(teaBuildConfiguration);
        TeaBuilder.config(teaBuildConfiguration);
        TeaVMTool tool = new TeaVMTool();
```

# Update core/build.gradle

Under dependencies, replace the api call of gdx with an api call of gdx-webgpu:
```
    dependencies {
        api "io.github.monstroussoftware.gdx-webgpu:gdx-webgpu:$gdxWebGPUVersion"
        //api "com.badlogicgames.gdx:gdx:$gdxVersion"

    }
```

# Update lwjgl3/build.gradle

Under dependencies, define a dependency on gdx-desktop-webgpu and on the project core
```
    dependencies {
      implementation "io.github.monstroussoftware.gdx-webgpu:gdx-desktop-webgpu:$gdxWebGPUVersion"
      implementation project(':core')
    
    }
```

# Update teavm/build.gradle

Under dependencies, define a dependency on backend-teavm, on gdx-teavm-webgpu and on the project core
```
    dependencies {
      implementation "com.github.xpenatan.gdx-teavm:backend-teavm:$gdxTeaVMVersion"
      implementation "io.github.monstroussoftware.gdx-webgpu:gdx-teavm-webgpu:$gdxWebGPUVersion"
      implementation project(':core')
   
    }
```


## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.
- `teavm`: Web backend that supports most JVM languages.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `teavm:build`: builds the JavaScript application into the build/dist/webapp folder.
- `teavm:run`: serves the JavaScript application at http://localhost:8080 via a local Jetty server.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
