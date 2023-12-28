package net.SirDizzypanda.SDEnchantments.enchantment;

import net.SirDizzypanda.SDEnchantments.SDEnchantments;
import net.SirDizzypanda.SDEnchantments.effect.BleedingEffect;
import net.SirDizzypanda.SDEnchantments.effect.EffectsClass;
import net.minecraft.world.InteractionHand;
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
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide){
            if (pAttacker.getUsedItemHand() == InteractionHand.MAIN_HAND) {
                if (pTarget instanceof LivingEntity target) {
                    target.addEffect(new MobEffectInstance(EffectsClass.BLEEDING.get(), 20 * pLevel), pTarget);
                }
            }
        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    public int getMaxLevel() {
        return 2;
    }
}
