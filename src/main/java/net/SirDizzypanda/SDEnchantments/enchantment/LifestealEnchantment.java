package net.SirDizzypanda.SDEnchantments.enchantment;

import net.SirDizzypanda.SDEnchantments.effect.EffectsClass;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LifestealEnchantment extends Enchantment {
    protected LifestealEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }



    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {

        if (!pAttacker.level().isClientSide) {
            pAttacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION,pLevel*20,2));
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);

    }
    public int getMaxLevel() {
        return 3;
    }
}

