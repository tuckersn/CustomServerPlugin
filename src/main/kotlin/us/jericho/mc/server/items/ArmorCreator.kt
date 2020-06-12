package us.jericho.mc.server.items

class ArmorCreator : ItemCreator {

    var health: Double? = null;

    constructor(): super();
    constructor(mat: String?, amount: Int?): super(mat, amount);
    constructor(mat: String?, min: Int, max: Int): super(mat, min, max);


    fun health(num: Double) {
        this.health = health;
    }


    override fun make() {
        
    }


}