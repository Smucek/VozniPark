package VozniPark

import scala.io.Source
import scala.swing.Font.{BoldItalic, Serif}
import scala.swing.{BoxPanel, Button, Dimension, Font, MainFrame, Orientation, Swing, Table}

class ProvjeraProzor extends MainFrame {
  title = "Pregled vozila kojima registracija istice u narednih 30 dana"
  minimumSize = new Dimension(1000, 500)

  val izvor = Source.fromFile("spisak vozila.txt")
  val vozilaString: Seq[String] = izvor.getLines().toSeq

  val vozila: Seq[Vozilo] = vozilaString.map { komanda =>
    val dijelovi: Seq[String] = komanda.split("\t")

    new Vozilo(marka = dijelovi(0), model = dijelovi(1), kategorija = dijelovi(2),
      godinaProizvodnje = dijelovi(3), datumReg = dijelovi(4), datumIstekaReg = dijelovi(5))
  }

  val spisakIsteka = vozila.filter { vozilo =>
    vozilo.istekRegistracije
  }

  val koloneTabeleNaslov = Seq("Marka", "Model", "Kategorija", "Gp", "DatumReg", "DatumIstek")
  val naslovi: Array[Array[Any]] = Array (
    Array("MARKA", "MODEL", "KATEGORIJA", "GODINA PROIZVODNJE", "DATUM REGISTRACIJE", "ISTEK REGISTRACIJE"))
  val tabelaNaslova = new Table (naslovi, koloneTabeleNaslov)

  tabelaNaslova.font = Font (Serif, BoldItalic, 10)

//  val spisak = spisakIsteka.map ( c => (c.markaVozila, c.modelVozila, c.kategorijaVozila,
//    c.godinaProizvodnjeVozila, c.datumRegVozila, c.datumIstekaRegVozila).toString.split(",")).toArray

  val spisak = spisakIsteka.map ( c => (c.markaVozila + "," + c.modelVozila + "," + c.kategorijaVozila +
    "," + c.godinaProizvodnjeVozila + "," + c.datumRegVozila + "," + c.datumIstekaRegVozila).split(",")).toArray

  val koloneTabele = Seq("Marka", "Model", "Kategorija", "Gp", "DatumReg", "DatumIstek")
  var vozilaZaTabelu: Array[Array[Any]] = spisak.asInstanceOf[Array[Array[Any]]]
  var tabela = new Table (vozilaZaTabelu: Array[Array[Any]], koloneTabele: Seq[String])

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
