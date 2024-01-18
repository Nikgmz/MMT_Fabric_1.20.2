package bg.nikgmz.tutorialmod.item;

import bg.nikgmz.tutorialmod.TutorialMod;
import bg.nikgmz.tutorialmod.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item URANIUM = registerItem("uranium", new Item(new FabricItemSettings()));
    public static final Item THORIUM = registerItem("thorium", new Item(new FabricItemSettings()));
    public static final Item ICON_GROUP_ITEM = registerItem("icongroupitem", new Item(new FabricItemSettings()));
    public static final Item RAW_THORIUM = registerItem("raw_thorium", new Item(new FabricItemSettings()));
    public static final Item RAW_URANIUM = registerItem("raw_uranium", new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        TutorialMod.LOGGER.info("Loading Mod Items for " + TutorialMod.MOD_ID);
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGorup);
    }
}
