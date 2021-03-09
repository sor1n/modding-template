package com.syszee.mod.mixin;

import net.minecraft.client.GameConfiguration;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class ExampleMixin
{
    @Inject(method = "<init>", at = @At("TAIL"), cancellable = true)
    public void wantsToStopRiding(GameConfiguration gameConfig, CallbackInfo ci)
    {
    }
}
