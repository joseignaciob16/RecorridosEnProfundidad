package interfacesfuncionales;

import javax.swing.tree.DefaultMutableTreeNode;

public class TNodo extends DefaultMutableTreeNode {

    private boolean Izquierdo;

    public TNodo() {
        this("");
    }

    public TNodo(String Texto) {
        super(Texto);
        Izquierdo = true;
    }
    
    public void setIzquierdo(boolean Izq) {
        Izquierdo = Izq;
    }

    public boolean getIzquierdo() {
        return Izquierdo;
    }
    
    protected TNodo Buscar (boolean Izq){
    int i;
    TNodo Nod;
    Nod=null;
        for (i = 0; i < getChildCount(); i++) {
            Nod=(TNodo)getChildAt(i);
            if(Nod.getIzquierdo()==Izq){
            break;
            }
            else{
            Nod=null;
            }
        }
        return Nod;
    }
    
    public TNodo HijoIzquierdo() {
        return Buscar(true);
    }

    public TNodo HijoDerecho() {
        return Buscar(false);
    }

    public boolean AgregarIzq(TNodo Nod) {
        if (HijoIzquierdo() == null) {
            Nod.setIzquierdo(true);
            add(Nod);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean AgregarDer(TNodo Nod) {
        if (HijoDerecho()== null) {
            Nod.setIzquierdo(false);
            add(Nod);
            return true;
        } else {
            return false;
        }
    }
    
    public String getTexto(){
    return getUserObject() + "";   
    }
    
    @Override
    public String toString() {
        String Texto;
        Texto=getTexto();
    if (getParent() == null) {
            return Texto;
        } else {
            if (Izquierdo) {
                return Texto + " (I)";
            } else {
                return Texto + " (D)";
            }
        }
    }
}

