#Deployment assistance

##Overview of the task

Contributor(s), reviewer(s) and progress was tracked in this issue:
[#11](https://github.com/BME-MIT-IET/iet-hf2021-v-dqw4w9wgxcq/issues/11)

###Original description (in Hungarian)
Deployment segítése (Docker, Vagrant, felhő szolgáltatásba telepítés...)

###Actionable subtasks
- Have a buildable CLI tool (#37)
- Have an artifact from the build process
- Make dockering (#11)

##Work done
After googling for "docker build for java",
I find that building an image can be separated from the java build process.
In my view, separation of the build process and the deployment results
in a more flexible approach.
The boundary of these stages interfaces only with a single artifact with each other.

So I wrote a simple Dockerfile and a .dockerignore file
to use our little CLI toolto run in Docker.
The docker build can be called after Gradle build only.

##Usage
- `gradle cli:shadowJar`
- `sudo docker build -t ontomalizer .`
- `sudo docker run -it --rm -v "$(pwd):/doc" ontomalizer /doc/file1`

##Lessons learned
Keep our Dockerfile simple with separation of build stages and using a moder build toochain.
