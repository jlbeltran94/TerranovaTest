package solutionsyn.mobile.terranovatest.data.models

/**
 * Created by jlbel on 24/09/2017.
 */
data class Material(
        var _id:String,
        var nombre:String,
        var explotacion_cargue:Float,
        var administracion:Float,
        var nomina:Float,
        var costo:Float,
        var subtotal_produccion:Float,
        var porcentaje_utilidad:Float,
        var utilidad:Float,
        var subtotal_m3:Float,
        var porcentaje_regalias:Float,
        var regalias:Float,
        var valor_publico:Float,
        var porcentaje_retefuente:Float,
        var retefuente:Float,
        var neto:Float
)