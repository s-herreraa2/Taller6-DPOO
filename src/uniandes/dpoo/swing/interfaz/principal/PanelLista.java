package uniandes.dpoo.swing.interfaz.principal;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelLista extends JPanel implements ListSelectionListener
{
    private JList<Restaurante> listaDeRestaurantes;

    private DefaultListModel<Restaurante> dataModel;

    private VentanaPrincipal ventanaPrincipal;

    public PanelLista( VentanaPrincipal ventanaPrincipal )
    {
        this.ventanaPrincipal = ventanaPrincipal;
        setBorder( new TitledBorder( "Restaurantes" ) );
        setLayout( new BorderLayout( ) );

        // crea la lista con un modelo de datos en el que puede haber sólo restaurantes
        dataModel = new DefaultListModel<>( );
        listaDeRestaurantes = new JList<>( dataModel );
        listaDeRestaurantes.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaDeRestaurantes.addListSelectionListener( this );

        // crear un panel con barras de desplazamiento para la lista
        JScrollPane scroll = new JScrollPane( listaDeRestaurantes );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );

        add( scroll );
    }

    public void actualizarRestaurantes( List<Restaurante> restaurantes )
    {
        List<Restaurante> nuevosRestaurantes = new ArrayList<Restaurante>( );
        for( Restaurante q : restaurantes )
        {
            if( !dataModel.contains( q ) )
                nuevosRestaurantes.add( q );
        }
        dataModel.addAll( nuevosRestaurantes );
    }

    @Override
    public void valueChanged( ListSelectionEvent e )
    {
        // revisa cuál es el restaurante seleccionado actualmente
        Restaurante seleccionado = listaDeRestaurantes.getSelectedValue( );

        // le envía la ventana principal el restaurante seleccionado para que se actualice el resto de la interfaz
        this.ventanaPrincipal.cambiarRestauranteSeleccionado( seleccionado );
    }

    public void seleccionarRestaurante( Restaurante restaurante )
    {
        listaDeRestaurantes.setSelectedValue( restaurante, true );
    }

}
