package VozniPark

import scala.io.Source
import scala.swing.{Dimension, MainFrame}

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

  vozila.foreach { vozilo => vozilo.istekRegistracije}








}
