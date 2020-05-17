package VozniPark

import scala.io.Source
import scala.swing.Font._
import scala.swing.{BoxPanel, Button, Dimension, Font, MainFrame, Orientation, Swing, Table}

class TabelaProzor extends MainFrame {
  title = "Pregled vozila"
  minimumSize = new Dimension(1000, 500)

  val koloneTabeleNaslov = Seq("Marka", "Model", "Kategorija", "Gp", "DatumReg", "DatumIstek")
  val naslovi: Array[Array[Any]] = Array (
    Array("MARKA", "MODEL", "KATEGORIJA", "GODINA PROIZVODNJE", "DATUM REGISTRACIJE", "ISTEK REGISTRACIJE"))
  val tabelaNaslova = new Table (naslovi, koloneTabeleNaslov)

  tabelaNaslova.font = Font (Serif, BoldItalic, 10)


  val izvor = Source.fromFile("spisak vozila.txt")
  val linije: Array[String] = izvor.getLines().toArray


  val vozila: Array[Array[String]] = linije.map {linija =>
   linija.split("\t")
  }

  val koloneTabele = Seq("Marka", "Model", "Kategorija", "Gp", "DatumReg", "DatumIstek")
  var podaci: Array[Array[Any]] = vozila.asInstanceOf[Array[Array[Any]]]
  var tabela = new Table (podaci: Array[Array[Any]], koloneTabele: Seq[String])


  val zatvoriDugme = Button("Zatvori"){
    close()
  }


  val panelGlavni = new BoxPanel(Orientation.Vertical)

  panelGlavni.contents += tabelaNaslova
  panelGlavni.contents += tabela
  panelGlavni.contents += Swing.VStrut(50)
  panelGlavni.contents += zatvoriDugme
  panelGlavni.border = Swing.EmptyBorder(90, 50, 50, 50)

  contents = panelGlavni
}
