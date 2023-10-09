package bg.nikgmz.tutorialmod.item;

import bg.nikgmz.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item URANIUM = registerItem("uranium", new Item(new FabricItemSettings()));
    public static final Item THORIUM = registerItem("thorium", new Item(new FabricItemSettings()));
    public static final Item ICON_GROUP_ITEM = registerItem("icongroupitem", new Item(new FabricItemSettings()));
    public static void addItemsToIngredientItemGorup(FabricItemGroupEntries entries){
        entries.add(URANIUM);
        entries.add(THORIUM);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        TutorialMod.LOGGER.info("Loading Mod Items for " + TutorialMod.MOD_ID);
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGorup);
    }
}
