package org.golde.snowball.exampleplugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.golde.snowball.api.SnowballAPI;
import org.golde.snowball.api.enums.SnowballMaterial;
import org.golde.snowball.api.enums.SnowballStepSound;
import org.golde.snowball.api.enums.SnowballEnchantmentEnum.SnowballEnchantmentRarity;
import org.golde.snowball.api.enums.SnowballEnchantmentEnum.SnowballEnchantmentSlot;
import org.golde.snowball.api.enums.SnowballEnchantmentEnum.SnowballEnchantmentType;
import org.golde.snowball.api.models.BlockModel;
import org.golde.snowball.api.models.ItemModel;
import org.golde.snowball.api.object.CustomBlock;
import org.golde.snowball.api.object.CustomEnchantment;
import org.golde.snowball.api.object.CustomItem;
public class ExamplePlugin extends JavaPlugin implements Listener {

	private SnowballAPI sbapi;
	
	@Override
	public void onLoad() {
		sbapi = SnowballAPI.getInstance(this);
		addExamples();
	}
	
	private void addExamples() {
		CustomBlock exampleBlock = new CustomBlock("Example Block", BlockModel.DEFAULT, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAHaSURBVDhPVZFNT1NBFIbnR0pJDQldWF20kJQFrQtKEzEpuKAlUSPCwrKpluCCy4avyIK6kbITdpYVZSd3Zu6dj2J9z8y0SnJyV+957nPeYU9+PMx8t8/OhnNHdjGyy19NvW02Wnrzo269U7uNNFpLT1aSbjW9LCdXC5LNdB/yZ3bucFiOTG3P1D+bRkt/2NI74/Tpq/R8CWl5vSD7Bcny3+z84XDRpVfbugn2Fth6dz09WFVgn1eTy0pyXRI3BTnICzZ/ZMsHtuZMmi2zua123urOxGQp6ZXlVSkBe5CX8axgMHHenq1g0mkopI9hAja8S2Ry59I2G7PangWbvLcVrvTs45WU2BWwJUzungukTZaPMpzV29Z7g/2lmUbwJnbopF8Qjs1NViD9BwvjNHnve3Y16b1EWvSLwcSzRxnaYa4TsNX+G7rSNUjsX0U5cCY2pMMO+/RedWCypk5eJ91l2at4E0rf57h5GsCTYaETd+U/b0oLl8bEYabcQkQmdCWx0XfRXZnjOqQfz3TMXCfU4E+w3ZX3uBJpx0NiNP3fwhRnSF94b7C9yaMrIYOvQKGEwB/odcad/M7x0Amo9Ad/rt+hoXfwndy+QINc+9fxDvjCh3YmLcWjDP8LMtQ71m8lLVkAAAAASUVORK5CYII=");
		sbapi.addBlock(exampleBlock);

		CustomItem exampleItem = new CustomItem("Example Item", ItemModel.DEFAULT, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABGdBTUEAALGPC/xhBQAAAAlwSFlzAAAOwgAADsIBFShKgAAAABh0RVh0U29mdHdhcmUAcGFpbnQubmV0IDQuMC41ZYUyZQAAAURJREFUOE+lkz9LQlEYxs93qc0P0KCLNeQgBEGIUHsQpLVKew1RDk6CIjQE9UHaEtwFdUka1LXl6f7u4fWe672B0vBcznmf5/1/rhvtKYXxj9RZSI25dDiVKjPpNjp3Ixvcpj51eV1JxYl0MJSO3rMofUovkSb0WR9a34nj6bN08pDFcd9rrr6SIPGHzBDVrhde30hvZemj4MG52fAcGrSDpQ8S90zZZEZwfy4N92MyBWxPtaQS2sHXMTAiUjaZEZr44s7jsZ4EtUpIyGAd07bslIrIMoXABoeGOz5sx7EqC0C/iMgaOgNscGi448OK/x8grwV6Dp0BNrhMCwzRAjCgnYfIKlgJq4GwYeWhfeY1lV6wxohwPM/wIZGFUukXcP7zIfEBPE8IqyQPZEZzufmUDUSlNPrLA5xlNqQCAPra/neW+wWVDNrNnIM3gAAAAABJRU5ErkJggg==");
		sbapi.addItem(exampleItem);

		CustomBlock exampleBlockGlass = new CustomBlock("Example Block (Glass)", BlockModel.DEFAULT, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuOWwzfk4AAACCSURBVDhPrZPBEYAgDATp/2tPFmAF/vzbQORiLobngTsTSIA7GZw065z3G/v1xXaMUfd4HjQKW0edoX2HCWDiWiR0VHHdijgNVkwaXjhqCYhdy18U6xJpELXEfzeYFUPn2kwmSIOoJfLDtRdUhl6giTK7Fi2JhDdh4IVr1D2eNzN7AOe/OpaBVFAuAAAAAElFTkSuQmCC");
		exampleBlockGlass.setMaterial(SnowballMaterial.GLASS);
		exampleBlockGlass.setTransparent(true);
		exampleBlockGlass.setSilktouch(true);
		exampleBlockGlass.setStepSound(SnowballStepSound.GLASS);
		sbapi.addBlock(exampleBlockGlass);

		CustomEnchantment ench1 = new CustomEnchantment("Very Cool Enchantment", SnowballEnchantmentRarity.RARE, SnowballEnchantmentType.ARMOR, SnowballEnchantmentSlot.ARMOR);
		ench1.setMaxEnchantmentLevel(10);
		sbapi.addEnchantment(ench1);

		CustomEnchantment ench2 = new CustomEnchantment("Evil But Good", SnowballEnchantmentRarity.COMMON, SnowballEnchantmentType.ARMOR, SnowballEnchantmentSlot.ALL);
		ench2.setMaxEnchantmentLevel(1);
		ench2.setCursedEnchantment();
		ench2.setTreasureEnchantment();

		sbapi.addEnchantment(ench2);
	}
	
}
