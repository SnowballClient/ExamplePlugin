package org.golde.snowball.exampleplugin;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.golde.snowball.api.SnowballAPI;
import org.golde.snowball.api.enums.SnowballEnchantmentEnum.SnowballEnchantmentRarity;
import org.golde.snowball.api.enums.SnowballEnchantmentEnum.SnowballEnchantmentSlot;
import org.golde.snowball.api.enums.SnowballEnchantmentEnum.SnowballEnchantmentType;
import org.golde.snowball.api.enums.SnowballMaterial;
import org.golde.snowball.api.enums.SnowballStepSound;
import org.golde.snowball.api.models.BlockModel;
import org.golde.snowball.api.models.ItemModel;
import org.golde.snowball.api.object.CustomBlock;
import org.golde.snowball.api.object.CustomCreativeTab;
import org.golde.snowball.api.object.CustomEnchantment;
import org.golde.snowball.api.object.CustomItem;
import org.golde.snowball.api.object.WhyDontYouWork;

public class ExamplePlugin extends JavaPlugin implements Listener {

	private SnowballAPI sbapi;

	@Override
	public void onLoad() {
		sbapi = SnowballAPI.getInstance(this);
		//addExamples();
		
		try {
			System.out.println(ExamplePlugin.class.forName("org.golde.snowball.api.object.CustomItem"));
			System.out.println(ExamplePlugin.class.forName("org.golde.snowball.api.object.WhyDontYouWork"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * If I uncomment this, bukkit for some reason can not find org.golde.snowball.api.object.WhyDontYouWork but finds org.golde.snowball.api.object.CustomItem
	 */
	/*private void addExamples() {
		
		
		//Generic Custom Block
		CustomBlock exampleBlock = new CustomBlock("Example Block", BlockModel.DEFAULT, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAHaSURBVDhPVZFNT1NBFIbnR0pJDQldWF20kJQFrQtKEzEpuKAlUSPCwrKpluCCy4avyIK6kbITdpYVZSd3Zu6dj2J9z8y0SnJyV+957nPeYU9+PMx8t8/OhnNHdjGyy19NvW02Wnrzo269U7uNNFpLT1aSbjW9LCdXC5LNdB/yZ3bucFiOTG3P1D+bRkt/2NI74/Tpq/R8CWl5vSD7Bcny3+z84XDRpVfbugn2Fth6dz09WFVgn1eTy0pyXRI3BTnICzZ/ZMsHtuZMmi2zua123urOxGQp6ZXlVSkBe5CX8axgMHHenq1g0mkopI9hAja8S2Ry59I2G7PangWbvLcVrvTs45WU2BWwJUzungukTZaPMpzV29Z7g/2lmUbwJnbopF8Qjs1NViD9BwvjNHnve3Y16b1EWvSLwcSzRxnaYa4TsNX+G7rSNUjsX0U5cCY2pMMO+/RedWCypk5eJ91l2at4E0rf57h5GsCTYaETd+U/b0oLl8bEYabcQkQmdCWx0XfRXZnjOqQfz3TMXCfU4E+w3ZX3uBJpx0NiNP3fwhRnSF94b7C9yaMrIYOvQKGEwB/odcad/M7x0Amo9Ad/rt+hoXfwndy+QINc+9fxDvjCh3YmLcWjDP8LMtQ71m8lLVkAAAAASUVORK5CYII=");
		sbapi.addBlock(exampleBlock);

		//Generic Custom Item
		CustomItem exampleItem = new CustomItem("Example Item", ItemModel.DEFAULT, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABGdBTUEAALGPC/xhBQAAAAlwSFlzAAAOwgAADsIBFShKgAAAABh0RVh0U29mdHdhcmUAcGFpbnQubmV0IDQuMC41ZYUyZQAAAURJREFUOE+lkz9LQlEYxs93qc0P0KCLNeQgBEGIUHsQpLVKew1RDk6CIjQE9UHaEtwFdUka1LXl6f7u4fWe672B0vBcznmf5/1/rhvtKYXxj9RZSI25dDiVKjPpNjp3Ixvcpj51eV1JxYl0MJSO3rMofUovkSb0WR9a34nj6bN08pDFcd9rrr6SIPGHzBDVrhde30hvZemj4MG52fAcGrSDpQ8S90zZZEZwfy4N92MyBWxPtaQS2sHXMTAiUjaZEZr44s7jsZ4EtUpIyGAd07bslIrIMoXABoeGOz5sx7EqC0C/iMgaOgNscGi448OK/x8grwV6Dp0BNrhMCwzRAjCgnYfIKlgJq4GwYeWhfeY1lV6wxohwPM/wIZGFUukXcP7zIfEBPE8IqyQPZEZzufmUDUSlNPrLA5xlNqQCAPra/neW+wWVDNrNnIM3gAAAAABJRU5ErkJggg==");
		sbapi.addItem(exampleItem);

		//Custom block that acts like glass
		CustomBlock exampleBlockGlass = new CustomBlock("Example Block (Glass)", BlockModel.DEFAULT, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuOWwzfk4AAACCSURBVDhPrZPBEYAgDATp/2tPFmAF/vzbQORiLobngTsTSIA7GZw065z3G/v1xXaMUfd4HjQKW0edoX2HCWDiWiR0VHHdijgNVkwaXjhqCYhdy18U6xJpELXEfzeYFUPn2kwmSIOoJfLDtRdUhl6giTK7Fi2JhDdh4IVr1D2eNzN7AOe/OpaBVFAuAAAAAElFTkSuQmCC");
		exampleBlockGlass.setMaterial(SnowballMaterial.GLASS);
		exampleBlockGlass.setTransparent(true);
		exampleBlockGlass.setSilktouch(true);
		exampleBlockGlass.setStepSound(SnowballStepSound.GLASS);
		sbapi.addBlock(exampleBlockGlass);

		//Custom good enchantment
		CustomEnchantment ench1 = new CustomEnchantment("Very Cool Enchantment", SnowballEnchantmentRarity.RARE, SnowballEnchantmentType.ARMOR, SnowballEnchantmentSlot.ARMOR);
		ench1.setMaxEnchantmentLevel(10);
		sbapi.addEnchantment(ench1);

		//Custom treasure enchantment that is also cursed
		CustomEnchantment ench2 = new CustomEnchantment("Evil But Good", SnowballEnchantmentRarity.COMMON, SnowballEnchantmentType.ARMOR, SnowballEnchantmentSlot.ALL);
		ench2.setMaxEnchantmentLevel(1);
		ench2.setCursedEnchantment();
		ench2.setTreasureEnchantment();
		sbapi.addEnchantment(ench2);
		
		//Another creative tab
		CustomCreativeTab creativeTab = new CustomCreativeTab("Another Tab!", new ItemStack(Material.WOOL, 1, (short) 3));
		sbapi.addCreativeTab(creativeTab);
		
		//Generic custom block in the custom creative tab
		CustomBlock creativeTabBlock = new CustomBlock("I Am In My Own Creative Tab", BlockModel.DEFAULT, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQAQMAAAAlPW0iAAAAA1BMVEX6/14A3kpdAAAAC0lEQVQI12MgEQAAADAAAWV61nwAAAAASUVORK5CYII=");
		creativeTabBlock.setCreativeTab(creativeTab);
		sbapi.addBlock(creativeTabBlock);
		
		WhyDontYouWork creativeTabItem = new WhyDontYouWork("Glowing Item", ItemModel.DEFAULT, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABGdBTUEAALGPC/xhBQAAAAlwSFlzAAAOwgAADsIBFShKgAAAABh0RVh0U29mdHdhcmUAcGFpbnQubmV0IDQuMC41ZYUyZQAAAURJREFUOE+lkz9LQlEYxs93qc0P0KCLNeQgBEGIUHsQpLVKew1RDk6CIjQE9UHaEtwFdUka1LXl6f7u4fWe672B0vBcznmf5/1/rhvtKYXxj9RZSI25dDiVKjPpNjp3Ixvcpj51eV1JxYl0MJSO3rMofUovkSb0WR9a34nj6bN08pDFcd9rrr6SIPGHzBDVrhde30hvZemj4MG52fAcGrSDpQ8S90zZZEZwfy4N92MyBWxPtaQS2sHXMTAiUjaZEZr44s7jsZ4EtUpIyGAd07bslIrIMoXABoeGOz5sx7EqC0C/iMgaOgNscGi448OK/x8grwV6Dp0BNrhMCwzRAjCgnYfIKlgJq4GwYeWhfeY1lV6wxohwPM/wIZGFUukXcP7zIfEBPE8IqyQPZEZzufmUDUSlNPrLA5xlNqQCAPra/neW+wWVDNrNnIM3gAAAAABJRU5ErkJggg==");
		sbapi.addItem(creativeTabItem);
		
//		CustomItemDrink drinkableItem = new CustomItemDrink("Drinkable Item", ItemModel.DEFAULT, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABGdBTUEAALGPC/xhBQAAAAlwSFlzAAAOwgAADsIBFShKgAAAABh0RVh0U29mdHdhcmUAcGFpbnQubmV0IDQuMC41ZYUyZQAAAURJREFUOE+lkz9LQlEYxs93qc0P0KCLNeQgBEGIUHsQpLVKew1RDk6CIjQE9UHaEtwFdUka1LXl6f7u4fWe672B0vBcznmf5/1/rhvtKYXxj9RZSI25dDiVKjPpNjp3Ixvcpj51eV1JxYl0MJSO3rMofUovkSb0WR9a34nj6bN08pDFcd9rrr6SIPGHzBDVrhde30hvZemj4MG52fAcGrSDpQ8S90zZZEZwfy4N92MyBWxPtaQS2sHXMTAiUjaZEZr44s7jsZ4EtUpIyGAd07bslIrIMoXABoeGOz5sx7EqC0C/iMgaOgNscGi448OK/x8grwV6Dp0BNrhMCwzRAjCgnYfIKlgJq4GwYeWhfeY1lV6wxohwPM/wIZGFUukXcP7zIfEBPE8IqyQPZEZzufmUDUSlNPrLA5xlNqQCAPra/neW+wWVDNrNnIM3gAAAAABJRU5ErkJggg==");
//		//drinkableItem.setMaxStackSize(1);
//		sbapi.addItem(drinkableItem);
//		
//		CustomItemFood itemFood = new CustomItemFood("Fill up yur hunger bar", ItemModel.DEFAULT, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAadEVYdFNvZnR3YXJlAFBhaW50Lk5FVCB2My41LjEwMPRyoQAABidJREFUWEfFlutTVOcdx81rd/ecswtYAS9xmphL26RpLooFqhSUKAEElvud5X5dYHdZdjnLxRC5uKAiYoAAS0AuQoSiRcWMkqhp6nQyTSa+6Uz+k08fmnEI4Wi1maEvPi+e7znn+f2e3+0524D/K5riVqIpbiWa4laiKW4lmuIvwZ0tYUvbTqHZIJba7/wUTfF/4cFyF+PeJC6rQQw7JfrrFFqKjLgtsnis/c0amuLz0F0hc6ZM4u64mUdfXuCft9tZ9L7HpEtmqklhWjXRXS7TJd75+bdrbBKelbPWXXSlywwVy4zYFMZVI1PNgayMmvl+9Tz3Lpcw1RLMp24jg/V6LtXLODMlyk5ujMiGTZ+FgZYDrPy1h2+/7Of62TSGLHsYSBQnTNEz4PTD16Bjrn0f/7jm4l8PR1jqj6BDRKAhVU9DpkJOtERCyHo0Nhl4EmqhnpZiiRGXxKdqMF/M5PHwhpfPp11cqfkT5+P2cClZwufw+0/oJ90mbviyuDnvZXZMxZXzK1rF9xmHFeKex4GClDfIittLkXkHieEK+R+YUCskLthk5r3vcmeunNW5Fj4ftDPtDGXUZuLjOvHcaqI5V+JU7UHu31livOMw3RUKuZESsSFGsfWP+28y+BivYx/DH51kabqNqTE3jfXhJETswRxmpDZNkCLjyDXR2xDI4sUors+5ubt8gfHeRNpF5XeWmmjLVzhj3c2deZXe6kA6Cg3UinSlHllv0U2G1yiN0XOq3MiI3cB024usztfy7V0vf/E58fXm02jZS0miguWEhDvPQG+VqIHqXfSeimFp1ktzweucrfGns2Tt+U4WPqmhs+xF2vKM2JIVypO2CzNPcKD4qB61wI+hekmcRE97gY5xp4Erp1/l2sBRVsRprs910deZxzn3a/TXG+kRDqyd9nTpLm5N19JXF0hzmSIiZaAmPYirw+V461+hURRhXYqRqqQn1IDdvJ2aNJmmXJkB648MifZpy9LTUSQz1iBz2bOTmZ7DPFg5w83ZchFqP9rE9Oup0DPZup/7Cw00FQdQlWAkT0SyPiOIpaFCemy/xZ5qwGrWURanF+Y0HKgUH9Qmm2gqkhhuCGbSG8FE824mXAo+p8KpbANqpp5Bh8ywup/V5XN8VLKPfqsf/TUKg869LA6XURxrIPqgROoxiVb76yyNVaIWvYFV5N9yQozpEyZhTsOB/Gg9FYkSfc2RfPdgjO/uXeHh7YssT+Qz3bpbREDkNHfNSYWL9gDu3eiluyqQLlFwXhHyC469dLoyOPKOTOTbBirNIo0lAXS7jlOV9jtyhENxog1Twp5QhBXxCl22P4rwzvDDo1usLvTx1fIZHn09KRw5zaj6a3KSFFHFOjpEu00ONeJODhBRkTlfqdDX+DLV5YmEvBlMouh11aJgEzlvqQ7DXniAsDcNRB3YOJI3OGATOZodbGL1po/PfBWMOvwZ8fyGO4vt/PDNoqjmfArjZU6G6VCrd/ChKwtXbAAfpin0V6zNh1cozggl7mAgRVESNQk6LMdl7OXRVGWHCRPrth6zYWEXvX11oomVhfMMNO5nzKEwVCculUvZIiXTLM80kRulJyZEwVUSiNqQhXp0B2qk6IAMI86Cl6grDcWaHkxpnIHkCD3xoestp8WGhTvTyPUZD3+7McZc33FhXGJQMHFROHBvikWfiiXWn5j3DBR84E+TOJXn93tQD4lwJyjUJL2M2xZP8rEgkqPWp93T2LBw5QhjZ818dXeUr6/1cfWTbD7rf5/l2Ra+//sUk5fspEcpRL2lJz06CI85FPVd4cAxE3XxfmTEvkRxZrjYaqORp7Fh0Wox0V4YwNTpVFYXO/jm9gAPVwa4f2uAW/OdOKpCiDgoKvwtHa4U4UBKJB6RDssJA1lROrHbNr3ghZ/u+d/YJLhEIba/L9Gd+CoTjiMsDGcyfi6d5oZwYg75E/4HicIICc/xnbRkRVP0Z+0fjWdFU/ScNOA5JNMn5v3HVkWMZEXc5xK50eI2O6pgTdJRFff0X61nRVN8jEfMcocYnZ4cheYcGXeKJG7Bp1f186Ip/pzKBDEh4yRKY39ZuLXQFLcSTXEr0RS3Ek1x62DbvwGahKYS5pr7GAAAAABJRU5ErkJggg==");
//		itemFood.setFoodAmount(10);
//		itemFood.setSaturation(400);
//		itemFood.setAlwaysEdible();
//		itemFood.setIsWolfFood();
//		sbapi.addItem(itemFood);
	}*/

}
