package vjezba

import java.io.{File, FileWriter}

import scala.swing.{BoxPanel, Button, ComboBox, Dialog, Dimension, Label, MainFrame, Orientation, Swing, Table, TextField}

class UnosProzor extends MainFrame {
  title = "Unos vozila"
  minimumSize = new Dimension(500, 120)

  val markaLabela = new Label("Marka vozila: ")
  val markaPolje = new TextField()
  markaPolje.columns = 10
  markaPolje.maximumSize = new Dimension(50, 20)
  markaPolje.preferredSize = new Dimension(50, 20)

  val panelMarka = new BoxPanel(Orientation.Horizontal)
  panelMarka.contents += markaLabela
  panelMarka.contents += Swing.HGlue
  panelMarka.contents += markaPolje


  val modelLabela = new Label("Model vozila: ")
  val modelPolje = new TextField()
  modelPolje.columns = 10
  modelPolje.maximumSize = new Dimension(50, 20)
  modelPolje.preferredSize = new Dimension(50, 20)

  val panelModel = new BoxPanel(Orientation.Horizontal)
  panelModel.contents += modelLabela
  panelModel.contents += Swing.HGlue
  panelModel.contents += modelPolje


  val kategorijaLabela = new Label("Kategorija vozila: ")
  val kategorijaDrop = new ComboBox(List("M1", "M2", "M3", "N1", "N2", "N3"))
  kategorijaDrop.maximumSize = new Dimension(50, 20)
  kategorijaDrop.preferredSize = new Dimension(50, 20)

  val panelKategorijaDrop = new BoxPanel(Orientation.Horizontal)
  panelKategorijaDrop.contents += kategorijaLabela
  panelKategorijaDrop.contents += Swing.HGlue
  panelKategorijaDrop.contents += kategorijaDrop


  val godinaLabela = new Label("Godina proizvodnje: ")
  val godinaPolje = new TextField()
  godinaPolje.columns = 3
  godinaPolje.maximumSize = new Dimension(50, 20)
  godinaPolje.preferredSize = new Dimension(50, 20)

  val panelGodina = new BoxPanel(Orientation.Horizontal)
  panelGodina.contents += godinaLabela
  panelGodina.contents += Swing.HGlue
  panelGodina.contents += godinaPolje


  val datumRegLabela = new Label("Datum registracije: ")
  val datumRegPolje = new TextField()
  datumRegPolje.columns = 6
  datumRegPolje.maximumSize = new Dimension(100, 20)
  datumRegPolje.preferredSize = new Dimension(100, 20)

  val panelDatumReg = new BoxPanel(Orientation.Horizontal)
  panelDatumReg.contents += datumRegLabela
  panelDatumReg.contents += Swing.HGlue
  panelDatumReg.contents += datumRegPolje


  val datumIstekaRegLabela = new Label("Datum isteka registracije: ")
  val datumIstekaRegPolje = new TextField()
  datumIstekaRegPolje.columns = 6
  datumIstekaRegPolje.maximumSize = new Dimension(100, 20)
  datumIstekaRegPolje.preferredSize = new Dimension(100, 20)

  val panelDatumIstekaReg = new BoxPanel(Orientation.Horizontal)
  panelDatumIstekaReg.contents += datumIstekaRegLabela
  panelDatumIstekaReg.contents += Swing.HGlue
  panelDatumIstekaReg.contents += datumIstekaRegPolje


    val koloneTabele = Seq("Marka", "Model", "Kategorija", "GP", "DatumReg", "DatumIstek")
    var podaci: Array[Array[Any]] = Array()

    var tabela = new Table(podaci, koloneTabele)

  val file = new File("spisak vozila.txt")
  val pisac = new FileWriter(file, true)

  val spasiDugme = Button("Spasi"){

    val podaciVozilaUpis = markaPolje.text + "\t" + modelPolje.text + "\t" + kategorijaDrop.selection.item + "\t" +
    godinaPolje.text + "\t" + datumRegPolje.text + "\t" + datumIstekaRegPolje.text + "\n"

    pisac.append(podaciVozilaUpis)

    val tekstIspisa = "Vozilo " + markaPolje.text + " " + modelPolje.text + " je uneseno"

    val novoVozilo: Array[Any] = Array(markaPolje.text,  modelPolje.text, kategorijaDrop.selection.item,
      godinaPolje.text, datumRegPolje.text, datumIstekaRegPolje.text)

    podaci = (novoVozilo :: podaci.toList).toArray

//    tabela = new Table (podaci, koloneTabele)
//    panelGlavni.contents(panelGlavni.contents.size - 1) = tabela
//    contents = panelGlavni

    pisac.close()

    close
    Dialog.showMessage(null, tekstIspisa, "Unos vozila", Dialog.Message.Info, null)
  }

  spasiDugme.maximumSize = new Dimension(80, 20)
  spasiDugme.preferredSize = new Dimension(80, 20)

  val cancelDugme = Button("Cancel"){
    close()
  }
  cancelDugme.maximumSize = new Dimension(80, 20)
  cancelDugme.preferredSize = new Dimension(80, 20)



  val panelGlavni = new BoxPanel(Orientation.Vertical)
  panelGlavni.contents += panelMarka
  panelGlavni.contents += panelModel
  panelGlavni.contents += panelKategorijaDrop
  panelGlavni.contents += panelGodina
  panelGlavni.contents += panelDatumReg
  panelGlavni.contents += panelDatumIstekaReg
  panelGlavni.contents += spasiDugme += Swing.VStrut(5) += cancelDugme

//  panelGlavni.contents += tabela

  panelGlavni.border = Swing.EmptyBorder(10, 10, 10, 10)


  contents = panelGlavni

//  sys.addShutdownHook({
//  pisac.close()
//  })
}
