plugins {
    id("net.labymod.labygradle")
    id("net.labymod.labygradle.addon")
}

val versions = providers.gradleProperty("net.labymod.minecraft-versions").get().split(";")

group = "io.slizza"
version = providers.environmentVariable("VERSION").getOrElse("1.0.4")

labyMod {
    defaultPackageName = "io.slizza.lowfire"

    minecraft {
        registerVersion(versions.toTypedArray()) {
            runs {
                getByName("client") {
                    devLogin = true
                }
            }
        }
    }

    addonInfo {
        namespace = "lowfire"
        displayName = "Low Fire"
        author = "SLIZZA"
        description = "Lowers the fire overlay on the screen when the player is on fire in first person."
        minecraftVersion = "1.8.9<1.21.1"
        version = rootProject.version.toString()
    }
}

subprojects {
    plugins.apply("net.labymod.labygradle")
    plugins.apply("net.labymod.labygradle.addon")

    group = rootProject.group
    version = rootProject.version
}