package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    private PanelEditarRestaurante panelDetalles;

    private PanelBotonesAgregar panelBotones;

    private PanelMapaAgregar panelMapa;

    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
        this.ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );

        // agrega el panel donde va a estar el mapa
        panelMapa = new PanelMapaAgregar( );
        add( panelMapa, BorderLayout.CENTER );

        // agrega en el sur un panel para los detalles del restaurante y para los botones
        panelDetalles = new PanelEditarRestaurante( );
        panelBotones = new PanelBotonesAgregar( this );

        JPanel panelSur = new JPanel( new BorderLayout( ) );
        panelSur.add( panelDetalles, BorderLayout.CENTER );
        panelSur.add( panelBotones, BorderLayout.SOUTH );
        add( panelSur, BorderLayout.SOUTH );

        // termina de configurar la ventana
        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setResizable( false );
    }

    public void agregarRestaurante( )
    {
        String nombre = panelDetalles.getNombre( );
        int calificacion = panelDetalles.getCalificacion( );
        boolean visitado = panelDetalles.getVisitado( );
        int[] coordenadas = panelMapa.getCoordenadas( );

        ventanaPrincipal.agregarRestaurante( nombre, calificacion, coordenadas[ 0 ], coordenadas[ 1 ], visitado );
        dispose( );
    }

    public void cerrarVentana( )
    {
        dispose( );
    }

}
