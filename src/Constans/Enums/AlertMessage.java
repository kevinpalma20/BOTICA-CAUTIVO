/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constans.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter; 

/**
 *
 * @author kpalmall
 */
@Getter 
@AllArgsConstructor
public enum AlertMessage {
    MESSAGE("Mensaje"),
    PDF_SUCCESS("Pdf generado correctamente, revise sus documentos."),
    EXECUTE_SUCCESS("Datos guardados correctamente."),
    FORBIDENN(" Verifique su correo o su contraseña."),
    RECOVERY_PASSWORD("Escriba su correo, se le enviará una contraseña."),
    RESTORED_PASSWORD("Se reestableció su contraseña.");

    private String value; 
}
