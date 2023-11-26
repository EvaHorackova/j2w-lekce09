[#ftl]
[@c.page title="Seznam osob"]
    <h1>Seznam osob</h1>

    [#list osoby.content] [#--seznam--]
        <table class="u-full-width">
            <thead>
            <tr>
                <th>Jméno</th>
                <th>Příjmení</th>
                <th>Datum narození</th>
            </tr>
            </thead>
            <tbody>
            [#items as osoba]
                <tr>
                    <td>${osoba.jmeno}</td>
                    <td>${osoba.prijmeni}</td>
                    <td>${osoba.datumNarozeni?date?string}</td>
                </tr>
            [/#items]
            </tbody>
        </table>
    [#else]
        <div>Seznam je prázdný.</div>
    [/#list]

    [@c.totalCount /] [#--makro pro počítání záznamů--]
    [@c.pager /] [#--makro pro řádkování--]
    [@c.controls /] [#--makro pro zobrazení celého formuláře a výběrového formuláře--]

[/@c.page]
