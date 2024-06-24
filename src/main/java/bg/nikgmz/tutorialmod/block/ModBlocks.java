package bg.nikgmz.tutorialmod.block;

import bg.nikgmz.tutorialmod.TutorialMod;
import bg.nikgmz.tutorialmod.block.custom.EnrichmentStation;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block THORIUM_BLOCK = registerBlock("thorium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.BONE)));
    public static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_URANIUM_BLOCK = registerBlock("raw_uranium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block RAW_THORIUM_BLOCK = registerBlock("raw_thorium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block URANIUM_ORE = registerBlock("uranium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)));
    public static final Block DEEPSLATE_URANIUM_ORE = registerBlock("deepslate_uranium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f)));
    public static final Block THORIUM_ORE = registerBlock("thorium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)));
    public static final Block DEEPSLATE_THORIUM_ORE = registerBlock("deepslate_thorium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f)));
    public static final Block ENRICHMENT_STATION = registerBlock("enrichment_station",
            new EnrichmentStation(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4f)));


    private static Block registerBlock(String name, Block block){
        registeringBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }
    private static Item registeringBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering Blocks for" + TutorialMod.MOD_ID);
    }
}
