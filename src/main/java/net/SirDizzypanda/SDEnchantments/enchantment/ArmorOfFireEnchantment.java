package net.SirDizzypanda.SDEnchantments.enchantment;

import net.SirDizzypanda.SDEnchantments.effect.EffectsClass;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ArmorOfFireEnchantment extends Enchantment {
    protected ArmorOfFireEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        if (!pAttacker.level().isClientSide){
            if (pAttacker instanceof LivingEntity attacker) {
                attacker.hurt((pTarget.damageSources().onFire()),1.0f);
                attacker.setSecondsOnFire(20*pLevel);
            }
        }
        super.doPostHurt(pTarget, pAttacker, pLevel);
    }

    public int getMaxLevel() {
        return 4;
    }
}
