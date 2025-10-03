# Medic!
Medic is a simple Health System Overhaul build for Fabric. It introduces injuries, methods of treatment and optionally, a Zombie Infection module.

These notes are to help me navigate this godforsaken editor and keep track of my goals. I don't like limb targeting and the messy balance associated with it so I won't be making a limb system. Damage is Damage. Doesn't matter if it's your heart or your head.

# Injury System

When taking any **damage**, there is a potential for you to gain an **injury**. There is no **Health Regeneration** (configurable) when **Medic!** is on.

- You cannot have multiple **injuries** at the same time.
- Only players can receive **injuries**.

The following **Injuries** have a chance (configurable) to occur when you are inflicted with the following **damage types**. Specific **injuries** require a certain threshold of **damage**

### Bleeding | Heavy Bleeding - Damage over time | Longer damage over time
    `arrow`
    `cactus`
    `generic`
    `mob_attack`
    `player_attack`
    `sweet_berry_bush`
    `thorns`
    `trident`
    
### Crippled | Crippled (Fall Damage) - Weakness | Slow
    `fall`
    `falling_anvil`
    `falling_block`
    `falling_stalactite`
    `fly_into_wall`
    `mace_smash`
    `mob_attack_no_aggro`
    `sonic_boom`
    `thrown`

### Burned - Max HP Reduced
    `campfire`
    `dry_out`
    `explosion`
    `fireball`
    `hot_floor`
    `in_fire`
    `lava`
    `lightning_bolt`
    `on_fire`
    `player_explosion`
    `unattributed_fireball`

### Frostbite - Max HP Reduced Severe
    `freeze`

# Medic System

For every injury, there's a **treatment**. These items can be crafted, but in a mod pack where you'd use **Medic!**, it's a better idea to make them uncraftable and add them to **loot_tables** instead.

- When certain **injuries** is treated, you go into **recovery**. In this window of time, you still suffer from a **minor debuff** that's associated with the injury you sustained.

### Bandage
    Recovers HP.
    *Remove Bleeding.*

### Plaster
    Recovers More HP.
    Recovery (Heavy Bleeding) - Attack Damage slightly reduced.
    *Remove Bleeding & Heavy Bleeding*

### Splint
    Recovery - Move Speed slightly reduced.
    *Remove Crippled*

### Salve
    Recovers HP
    Recovery - Max HP Slightly reduced.
    *Remove Burned & Frostbite*

### Med Kit
    Recovers HP
    *Remove Any Injury* (Not Recovery)

### Pain Killer
    Absorption
    *Suppress & Prevent Injuries temporarily*

# Infection System

An optional module that's enabled by default. When **injured** by a **Zombie** or **Zombie Villager**, there's a chance for you to gain the **Bitten** status effect. When Bitten, a timer starts to count down. When it resolves the status disappears and from there, it's a mystery of whether you're **infected** or not.

### Stage I
    You will begin to develop nausea at random.

### Stage II
    In combination with the effect in Stage I, you will also gain the Darkness status effect periodically.

### Stage III
    In the final stage, in combination with the effects of Stage I & II, you will randomly gain slowness & weakness. After this stage concludes, you die.

# Cure System

There's always a way out.

### Elixir Patch - Will halt Infection and remove all symptoms of it's stage for 5 minutes. There is a small chance it even cures the Infected. There's a smaller chance that after the timer expires, the infected jumps up to Stage III. Otherwise, after the Elixir Patch wears off, the Infection goes back to Stage I.

### Elixir - When used, it will cure the Infected of their Infection. It also removes the Elixir Patch upon use.

---

Oh sweet summer child you should've stuck to the datapacks!

The debuffs on using treatments was rough in testing. So I gave a slight boost for a time instead. Considering how difficult it is to get potion effects without a brewing stand and special ingredients, this is good enough.

The Max HP removal mechanic worked but I couldn't make it come back consistently. I could've played it off like "oh man you got frostbite and lost a toe :o" but decided not to. Mod is already enough to clean up without me trying to get that to work.

Half the burn effects straight up don't trigger Heatstroke. Probably because they aren't direct damage.

Considering how much trouble I was having with getting these status effects to hide, I'm not sure how well I can pull off the Zombie Infection Module. I can do the progressing stages for sure but making it look elegant and not clunky is going to be the death of me.

Painkillers are a nice idea in theory but you already have a Med-Kit. If I could make items take time to use maybe then they wouldn't be redundant?