# Neuro Evolution Vehicles Plugin Sample

## How to
In order to create Track plugins, clone this repository and perform the following maven command:
```bash
mvn clean install
```
If you also want the JavaDoc for the plugin package execute:
```bash
mvn dependency:sources
```

Afterwards you can open the project with any text editor of your choice.

After you created your track perform the following command to build the plugin:
```bash
mvn clean package
```
The created jar file will be placed in the target/ directory. This jar file is your plugin and needs to be placed in the plugins directory of the NeuroEvolutionVehicles project.

## Development
In order to created a new Track plugin you need to create a class which implements the Track interface, as the MyTrack.java class does.
By doing this it doesn't matter what package you use and how you name your class. The NeuroEvolutionVehicles project will automatically load your plugin from the plugins directory and scan for any class that implements the Track interface.