package solutionsyn.mobile.terranovatest.data.models

import java.util.*

/**
 * Created by jlbel on 24/09/2017.
 */
data class Order(
        var _id:String,
        var client: Client,
        var fecha: Date,
        var mts_pedidos:Float,
        var mts_entregados:Float,
        var mts_pendientes:Float,
        var estado:Boolean,
        var material: Material,
        var zona_cobro:Zone
)