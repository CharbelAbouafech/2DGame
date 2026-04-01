package My2DGame;

import Entity.NPC_OldMan;
import Object.OBJ_Key;
import Object.OBJ_Door;
import Object.OBJ_Chest;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Key(gp);
        gp.obj[0].worldX = gp.tileSize * 23;
        gp.obj[0].worldY = gp.tileSize * 19;

        gp.obj[1] = new OBJ_Door(gp);
        gp.obj[1].worldX = gp.tileSize * 10;
        gp.obj[1].worldY = gp.tileSize * 10;

        gp.obj[2] = new OBJ_Chest(gp);
        gp.obj[2].worldX = gp.tileSize * 10;
        gp.obj[2].worldY = gp.tileSize * 9;
    }
    public void setNPC() {
        gp.npc[0] = new    NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize*21;
        gp.npc[0].worldY = gp.tileSize*21;
    }
}
