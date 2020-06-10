package us.jericho.mc.server.items

class WeaponCreator : ItemCreator {

    var itemWeapon: String? = null;
    var itemType: String? = null;

    constructor(): super();
    constructor(mat: String?, amount: Int?): super(mat, amount);
    constructor(mat: String?, min: Int, max: Int): super(mat, min, max);

    fun setWeapon(weapon: String) {
        this.itemWeapon = weapon;
    }

    fun randomWeapon(leather: Int?, gold: Int?, chain: Int?, iron: Int?, diamond: Int?, turtle: Int? ) {

    }

    fun weaponPercentage(leather: Int?, gold: Int?, chain: Int?, iron: Int?, diamond: Int?, turtle: Int? ) {
        var weaponTypes: MutableMap<String, Float> = mutableMapOf<String, Float>();
        var total: Int = 0;

        if(leather != null) {
            total += leather
            weaponTypes.put( "leather", leather.toFloat() );
        }
    }

    fun setType(type: String) {
        this.itemType = type;
    }


}