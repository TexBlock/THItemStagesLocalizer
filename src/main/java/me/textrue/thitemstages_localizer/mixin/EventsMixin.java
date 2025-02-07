package me.textrue.thitemstages_localizer.mixin;

import com.decursioteam.thitemstages.events.Events;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Events.class)
public class EventsMixin {
    @WrapOperation(method = "lambda$onItemTooltip$6", at = @At(value = "INVOKE", target = "Lnet/minecraft/text/Text;literal(Ljava/lang/String;)Lnet/minecraft/text/MutableText;"))
    private static MutableText itemTitleLocalizer(String string, Operation<MutableText> original) {
        return Text.translatable(string).copy();
    }
}
