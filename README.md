# Underground Pit Mod
Minecraft 1.8.9 Forge mod for the Hypixel minigame The Pit.  
The mod let's you view the event schedule without paying for "Pit Supporter".  

The mod let's you filter the schedule with these options:  
* all events
* specific event
* major events
* minor events

The mod also let's you view the current and upcoming maps

Special thanks to [BrookeAFK](https://github.com/brooke-gill) for creating the [API](https://github.com/BrookeAFK/brookeafk-api)

## Download

You can download the `.jar` file here: https://github.com/Intedai/UndergroundPitMod/releases  
If you wanna build the mod yourself scroll down to the `Build` section
## Showcase
<img width="588" height="383" alt="UPM" src="https://github.com/user-attachments/assets/d6ace29e-d168-4d64-996e-810eaca24065" />  

`/upm` - View upcoming events  

<img width="591" height="106" alt="UPM MAP|S" src="https://github.com/user-attachments/assets/c8e9f877-49a0-4589-ace1-4cf943609183" />  

`/upm map` or `/upm maps` - View current and next map

<img width="586" height="373" alt="UPM DRAGON EGG" src="https://github.com/user-attachments/assets/1187ba83-c616-4fef-be94-60f380a2a304" />  

`/upm <EVENT>` - View an event's schedule

<img width="649" height="371" alt="UPM MAJOR" src="https://github.com/user-attachments/assets/62cdc445-716c-4ef5-9ea2-c438d84682a7" />  

`/upm major` - View upcoming major events  

<img width="584" height="374" alt="UPM MINOR" src="https://github.com/user-attachments/assets/35b4c6f4-918b-4e80-a51c-d6819d3b67e4" />  

`/upm minor` - View upcoming minor events  

<img width="582" height="79" alt="UPM REFRESH" src="https://github.com/user-attachments/assets/bddf2098-9352-41f0-b246-7dc4dc43febc" />  

`/upm refresh` - Refresh API data  

## View commands in-game
<img width="675" height="241" alt="UPM HELP" src="https://github.com/user-attachments/assets/4feed5c1-45a8-4a29-ad72-dd5683fb6b40" />  

`/upm help`  

<img width="669" height="215" alt="UPM BAD" src="https://github.com/user-attachments/assets/83ae520a-db5d-4e6c-9698-68400e9e56e9" />  

`bad /upm command`

## Build
Make sure you're using Java 8 and then run `./gradlew build`  
the `.jar` file will be in `/build/libs/`.  
Copy it to your mods folder (make sure you copy the file that doesn't have `sources` in it's name)
