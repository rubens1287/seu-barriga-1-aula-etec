package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class CriarMovimentacaoPage extends DriverManager {

    private By cbbTipoMovimentacao = By.id("tipo");
    private By txtDataMov = By.id("data_transacao");
    private By txtDataPagamento = By.id("data_pagamento");
    private By txtDescricao = By.id("descricao");
    private By txtInteressado = By.id("interessado");
    private By txtValor = By.id("valor");
    private By cbbCnta = By.id("conta");
    private By btnSalvar = By.xpath("//button[contains(text(),'Salvar')]");
    private By lblOpSucesso = By.xpath("//div[contains(text(),'Movimentação adicionada com sucesso!')]");


    public boolean isPresent(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(cbbTipoMovimentacao)).isDisplayed();
    }

    public void cadastrarMovimentacao(String tipoMovimentacao, String valor, String conta, String statusPagamento ){
        //LocalTime localTime = LocalTime.now(ZoneId.of("GMT+02:30"));

        new Select(driver.findElement(cbbTipoMovimentacao))
                .selectByVisibleText(tipoMovimentacao);
        driver.findElement(txtDataMov).sendKeys("16/06/2020");
        driver.findElement(txtDataPagamento).sendKeys("16/06/2020");
        driver.findElement(txtDescricao).sendKeys("Teste automatizado");
        driver.findElement(txtInteressado).sendKeys("Teste");
        driver.findElement(txtValor).sendKeys(valor);
        new Select(driver.findElement(cbbCnta))
                .selectByVisibleText(conta);

        driver.findElement(By.xpath("//input[@id='status_"+statusPagamento+"']")).click();

        driver.findElement(btnSalvar).click();
    }

    public boolean validaMensagemSucesso(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(lblOpSucesso)).isDisplayed();

    }

}
