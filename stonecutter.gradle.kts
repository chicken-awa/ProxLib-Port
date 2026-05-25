plugins {
    id("dev.kikugie.stonecutter")
    id("net.neoforged.moddev") version "2.0.141" apply false
    //id("dev.kikugie.j52j") version "1.0.2" apply false // Enables asset processing by writing json5 files
    //id("me.modmuss50.mod-publish-plugin") version "0.7.+" apply false // Publishes builds to hosting websites
}
stonecutter active "1.21" /* [SC] DO NOT EDIT */


/*
// Publishes every version
stonecutter registerChiseled tasks.register("chiseledPublishMods", stonecutter.chiseled) {
    group = "project"
    ofTask("publishMods")
}
*/

/*
for (meta in stonecutter.versions) {
    stonecutter registerChiseled tasks.register("build-${meta.project}", stonecutter.chiseled) {
        versions { _, it -> it == meta }
        group = "project"
        ofTask("build")
    }
}
*/

stonecutter parameters {
    /*
    See src/main/java/com/example/TemplateMod.java
    and https://stonecutter.kikugie.dev/
    */
    // Swaps replace the scope with a predefined value
    swaps["mod_version"] = "\"${property("mod.version")}\";"
    // Constants add variables available in conditions
    constants["release"] = property("mod.id") != "template"
    // Dependencies add targets to check versions against
    // Using `node.property()` in this block gets the versioned property
    dependencies["neoforge"] = findProperty("deps.neo_version").toString()
}
