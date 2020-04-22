/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.util.slack;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 *
 * @author Abraxas
 */
@lombok.AllArgsConstructor
@Builder(builderClassName = "Builder")
@lombok.Getter
@lombok.Setter
public class SlackPoruka implements Serializable{
    private String username;
    private String text;
    private String icon_emoji;
}
