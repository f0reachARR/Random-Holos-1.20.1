package net.theivan066.randomholos.screen.renderer;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.energy.IEnergyStorage;

import java.util.List;

/*
 *  BluSunrize
 *  Copyright (c) 2021
 *
 *  This code is licensed under "Blu's License of Common Sense"
 *  https://github.com/BluSunrize/ImmersiveEngineering/blob/1.19.2/LICENSE
 *
 */
public class EnergyDisplayArea {
    private final int xPos;
    private final int yPos;
    private final int width;
    private final int height;
    private final IEnergyStorage energy;

    public EnergyDisplayArea(int xMin, int yMin, IEnergyStorage energy) {
        this(xMin, yMin, energy, 10, 64);
    }

    public EnergyDisplayArea(int xMin, int yMin, IEnergyStorage energy, int width, int height) {
        xPos = xMin;
        yPos = yMin;
        this.width = width;
        this.height = height;
        this.energy = energy;
    }

    public List<Component> getTooltips() {
        return List.of(Component.literal(energy.getEnergyStored() + " / " + energy.getMaxEnergyStored() + " FE"));
    }

    public void render(GuiGraphics guiGraphics) {
        int stored = (int) (height * (energy.getEnergyStored() / (float) energy.getMaxEnergyStored()));
        guiGraphics.fillGradient(xPos, yPos + (height - stored), xPos + width,
                yPos + height, 0xffb51500, 0xff600b00);
    }
}
