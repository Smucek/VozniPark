package VozniPark

import vjezba.UnosProzor

import scala.swing.{BoxPanel, Button, Dimension, MainFrame, Orientation, Swing}
class PrviProzor extends MainFrame {
  title = "Prvi prozor"
  minimumSize = new Dimension(300, 300)


  val unesiVoziloDugme = Button("Unesi novo vozilo"){

      val dodavanje = new UnosProzor
      dodavanje.visible = true
  }


  unesiVoziloDugme.preferredSize = new Dimension(150, 50)
  unesiVoziloDugme.minimumSize = new Dimension(150, 50)
  unesiVoziloDugme.maximumSize = new Dimension(150, 50)


  val pregledVozilaDugme = Button("Pregled svih vozila"){

    val dodavanje = new TabelaProzor
    dodavanje.visible = true
  }
  pregledVozilaDugme.preferredSize = new Dimension(150, 50)
  pregledVozilaDugme.minimumSize = new Dimension(150, 50)
  pregledVozilaDugme.maximumSize = new Dimension(150, 50)

  val izlazDugme = Button("Izlaz"){
  System.exit(1)
  }
  izlazDugme.preferredSize = new Dimension(150, 50)
  izlazDugme.minimumSize = new Dimension(150, 50)
  izlazDugme.maximumSize = new Dimension(150, 50)

  val panelGlavni = new BoxPanel(Orientation.Vertical)
//  panelGlavni.contents += Swing.HStrut(5)
//  panelGlavni.contents += Swing.VStrut(5)
  panelGlavni.contents += unesiVoziloDugme
  panelGlavni.contents += Swing.VStrut(5)
  panelGlavni.contents += pregledVozilaDugme
  panelGlavni.contents += Swing.VStrut(5)
  panelGlavni.contents += izlazDugme
  panelGlavni.border = Swing.EmptyBorder(90, 100, 100, 100)

  contents = panelGlavni


}

object Pocetak{
  def main(args: Array[String]) = {

    val pocetniProzor = new PrviProzor()

    pocetniProzor.visible = true
  }
}
