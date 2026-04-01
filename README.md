# 2D Adventure Game

A top-down 2D RPG engine built in Java using Swing/AWT. Features tile-based world rendering, player movement, collision detection, NPC support, interactive objects, and a music/sound system.

## Features

- 60 FPS game loop with delta-time interpolation
- Tile-based world (50x50 tiles, 2400x2400px world)
- Player-centered camera with world edge locking
- 8-directional sprite animation (2 frames per direction)
- Tile collision detection
- Interactive objects: key, door, chest, boots
- NPC system (Old Man NPC)
- Background music and sound effects
- Pause menu (P key)
- Debug draw-time display (T key)

## Project Structure

```
2DGame/
├── Entity/
│   ├── Entity.java           # Base class for all entities (player, NPCs)
│   ├── Player.java           # Player character with input handling and camera
│   └── NPC_OldMan.java       # Old Man NPC
├── My2DGame/
│   ├── My2DGame.java         # Entry point — creates JFrame and starts game
│   ├── GamePanel.java        # Core game loop, state management, rendering
│   ├── KeyHandler.java       # Keyboard input (WASD, P, T)
│   ├── CollisionChecker.java # Tile and object collision detection
│   ├── AssetSetter.java      # Spawns objects and NPCs into the world
│   ├── Sound.java            # Audio playback (music + SFX)
│   ├── UI.java               # Pause screen and HUD
│   └── UtilityTool.java      # Image scaling utility
├── Object/
│   ├── SuperObject.java      # Base class for interactive world objects
│   ├── OBJ_Key.java          # Key item
│   ├── OBJ_Door.java         # Door (blocks movement)
│   ├── OBJ_Chest.java        # Chest
│   └── OBJ_Boots.java        # Speed boots
├── tile/
│   ├── Tile.java             # Tile data (image + collision flag)
│   └── TileManager.java      # Loads and renders the tile map
├── res/
│   ├── maps/                 # World map text files (worldV2.txt is active)
│   ├── npc/                  # NPC sprite sheets
│   ├── objects/              # Object sprites (key, door, chest, boots)
│   ├── player/               # Player sprite sheets
│   └── sound/                # Music and SFX (.wav)
└── tiles/                    # Tile textures (grass, water, road, wall, tree, etc.)
```

## Controls

| Key           | Action                        |
|---------------|-------------------------------|
| W / A / S / D | Move up / left / down / right |
| P             | Pause / unpause               |
| T             | Toggle debug draw time        |

## How to Run

1. Open the project in IntelliJ IDEA (or any Java IDE).
2. Set the source root to the project root directory.
3. Run `My2DGame/My2DGame.java`.

Requires Java 8 or later. No external dependencies.

## Game Settings

| Setting      | Value                |
|--------------|----------------------|
| Screen size  | 768 x 576 pixels     |
| Tile size    | 48 x 48 pixels       |
| Screen tiles | 16 columns x 12 rows |
| World size   | 50 x 50 tiles        |
| Player speed | 4 px/frame           |
| Target FPS   | 60                   |

## Sound

Background music and sound effects are managed by `Sound.java`. Music loops automatically on game start. Available tracks include `BlueBoyAdventure`, `Dungeon`, `FinalBattle`, and `Merchant`. SFX include coin, powerup, unlock, fanfare, and more.

## Current State

The core engine (rendering, movement, collision, audio) is functional. The following systems are stubbed and not yet implemented:

- Item pickup logic (`Player.pickUpObject()`)
- Object spawning (`AssetSetter.setObject()`)
- NPC dialogue / interaction
- Win/loss conditions
- Inventory system
