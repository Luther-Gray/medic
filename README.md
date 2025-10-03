CAUTION - ALPHA and my first mod

Roadmap - No Promises
  Zombie Infection Module
  A proper config using cloth or owo
  Mod Intergrations with mods that add new Damage Types

Medic! Medic is a simple Health System Overhaul built for Fabric. It introduces injuries, methods of treatment and optionally, a Zombie Infection module.

Injury System

When taking any damage, there is a potential for you to gain an injury associated with the type of damage you took.

Bleeding

    Damage over Time

Heavy Bleeding

    Deadly Damage over Time

Crippled

    Weakness | Slow

Heatstroke

    Nausea

Frostbite

    Mining Fatigue

Medic System

For every injury, there's a treatment. These items can be crafted, but in a mod pack where you'd use Medic!, it's a better idea to make them uncraftable and add them to loot_tables instead.

When certain injuries are treated, you go into recovery. In this window of time, you cannot be inflicted with the same injury again.

Bandage

    Recovers HP.
    Remove Bleeding.

Plaster

    Recovers More HP.
    Recovery (Heavy Bleeding) - Saturation
    Remove Bleeding & Heavy Bleeding

Splint

    Recovery (Crippled) - Resistance
    Remove Crippled

Salve

    Recovers HP
    Recovery - Health Boost
    Remove Burned & Frostbite

Med-Kit

    Recovers HP
    Absorption
    Remove Any Injury (No Recovery)

Infection System | WIP |

An optional module that's enabled by default. When injured by a Zombie or Zombie Villager, there's a chance for you to gain the Bitten status effect. When Bitten, a timer starts to count down. When it resolves the status disappears and from there, it's a mystery of whether you're infected or not.

Stage I

    You will begin to develop nausea at random.

Stage II

    In combination with the effect in Stage I, you will also gain the Darkness status effect periodically.

Stage III

    In the final stage, in combination with the effects of Stage I & II, you will randomly gain slowness & weakness. After this stage concludes, you die.

Cure System

There's always a way out.

Elixir Patch

    Will halt Infection and remove all symptoms of it's stage for a time. There is a small chance it even cures the Infected. There's a smaller chance that after the timer expires, the Infected jumps up to Stage III. Otherwise, after the Elixir Patch wears off, the Infection goes back to Stage I.

Elixir

    When used, it will cure the Infected of their Infection. It also removes the Elixir Patch upon use.

