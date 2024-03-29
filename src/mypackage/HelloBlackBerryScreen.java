package mypackage;

import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.util.StringProvider;

public class HelloBlackBerryScreen extends MainScreen {
    private BasicEditField basicEditField;

    public HelloBlackBerryScreen() {
        super( MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR );
        setTitle( "HelloBlackBerry" );

        basicEditField = new BasicEditField( "Enter Name:", "", 100, BasicEditField.EDITABLE );
        add( basicEditField );

        ButtonField buttonField_1 = new ButtonField( "Say Hello to", ButtonField.CONSUME_CLICK | ButtonField.FIELD_RIGHT );
        add( buttonField_1 );
        buttonField_1.setChangeListener( new FieldChangeListener() {
            public void fieldChanged( Field arg0, int arg1 ) {
                sayHello();
            }
        } );
    }

    protected void makeMenu( Menu menu, int instance ) {
    	super.makeMenu(menu, instance);
        MenuItem mntmSayHello = new NewMenuItem();
        menu.add( mntmSayHello );
    }

    private class NewMenuItem extends MenuItem {
        public NewMenuItem() {
            super( new StringProvider( "Say Hello" ), 0, 0 );
        }

        public void run() {
            sayHello();
        }
    }

    private void sayHello() {
        Dialog.inform( "Hello " + basicEditField.getText() );
    }
}
