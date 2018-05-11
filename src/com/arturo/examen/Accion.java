/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arturo.examen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "com.arturo.examen.Accion"
)
@ActionRegistration(
        iconBase = "com/arturo/examen/icono.png",
        displayName = "#CTL_Accion"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_Accion=Packager")
public final class Accion implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String so=JOptionPane.showInputDialog(null, "Introduce exe para Windows y deb para Linux");
        String cat=JOptionPane.showInputDialog(null, "Introduce el nombre de la categoria deseada");
        String carp=JOptionPane.showInputDialog(null, "Introduce Ruta de carpeta de destino");
        String file=JOptionPane.showInputDialog(null, "Introduce nombre deseado del Instalador");
        String rDist=JOptionPane.showInputDialog(null, "Introduce Ruta de la carpeta dist");
        String jar=JOptionPane.showInputDialog(null, "Introduce Nombre del archivo .jar");
        String main=JOptionPane.showInputDialog(null, "Introduce Nombre de la clase main del programa");
        String nApp=JOptionPane.showInputDialog(null, "Introduce Nombre de la App");
        String title=JOptionPane.showInputDialog(null, "Introduce Titulo para la App");
        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("javapackager "
                    + "-deploy "
                    + "-native "+so+" -Bcategory="+cat+" "
                    + "-outdir "+carp+" "// /home/local/DANIELCASTELAO/aralvarellosblas/Documentos/contornos/Hola/Hola "
                    + "-outfile "+file+" "
                    + "-srcdir "+rDist+" "// /home/local/DANIELCASTELAO/aralvarellosblas/Documentos/contornos/Hola/dist "
                    + "-srcfiles "+jar+" "
                    + "-appclass "+main+" "
                    + "-name "+nApp+" "
                    + "-title "+title);

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
