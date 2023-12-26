package net.SirDizzypanda.SDEnchantments.enchantment;

import net.SirDizzypanda.SDEnchantments.SDEnchantments;
import net.SirDizzypanda.SDEnchantments.effect.BleedingEffect;
import net.SirDizzypanda.SDEnchantments.effect.EffectsClass;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class DissectionEnchantment extends Enchantment {
    public DissectionEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }



    @Override
    public void doPostHurt(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (!pTarget.level().isClientSide()) {
            pAttacker.addEffect(new MobEffectInstance(EffectsClass.BLEEDING.get(),pLevel*5));
        }
        super.doPostHurt(pAttacker, pTarget, pLevel);
    }

    public int getMaxLevel() {
        return 2;
    }
}
