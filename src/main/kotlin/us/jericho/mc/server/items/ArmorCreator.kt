package us.jericho.mc.server.items

class ArmorCreator : ItemCreator {


    constructor(): super();
    constructor(mat: String?, amount: Int?): super(mat, amount);
    constructor(mat: String?, min: Int, max: Int): super(mat, min, max);




}