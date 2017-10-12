package solutionsyn.mobile.terranovatest.data.models

import java.util.*

/**
 * Created by jlbel on 24/09/2017.
 */
data class Delivery(
        var _id:String,
        var codigo_preorden:String,
        var metros_enviados:Float,
        var volqueta:Transporter,
        var material: Material,
        var zona:String,
        var fecha_envio:Date,
        var hora_envio:String,
        var foto:String,
        var numero_remision:Int,
        var valor_unitario:Float,
        var valor_transporte:Float,
        var valor_total:Float,
        var cliente:String
        )