package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{
    private JLabel labNombre;

    private JLabel labCalificacion;

    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante( )
    {
        // configura la etiqueta para el nombre
        labNombre = new JLabel( );
        JPanel pNombre = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        pNombre.add( new JLabel( "Nombre: " ) );
        pNombre.add( labNombre );

        // configura la etiqueta para la calificación
        labCalificacion = new JLabel( );
        JPanel pCalificacion = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        pCalificacion.add( new JLabel( "Calificación: " ) );
        pCalificacion.add( labCalificacion );

        // configura el checkbox para indicar si ya se visitó o no el restaurante
        chkVisitado = new JCheckBox( );
        chkVisitado.setEnabled( false ); // solo se muestra, el usuario no lo edita
        JPanel pVisitado = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        pVisitado.add( new JLabel( "Visitado: " ) );
        pVisitado.add( chkVisitado );

        // organiza los elementos en la ventana
        setLayout( new GridLayout( 3, 1 ) );
        add( pNombre );
        add( pCalificacion );
        add( pVisitado );
    }

    private void actualizarRestaurante( String nombre, int calificacion, boolean visitado )
    {
        labNombre.setText( nombre );
        labCalificacion.setIcon( buscarIconoCalificacion( calificacion ) );
        chkVisitado.setSelected( visitado );
    }

    public void actualizarRestaurante( Restaurante r )
    {
        this.actualizarRestaurante( r.getNombre( ), r.getCalificacion( ), r.isVisitado( ) );
    }

    private ImageIcon buscarIconoCalificacion( int calificacion )
    {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon( imagen );
    }
}
