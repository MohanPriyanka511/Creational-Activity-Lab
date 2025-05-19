let d = document.querySelector("#donerdata")
fetch("http://localhost:8080/LocalBloodDoner/senddata").then(e => e.json().then(data => {
    // console.log(data)
    let array_val = Object.values(data)
    // console.log(val)
    array_val.forEach(e => {
        let val = Object.values(e)
        console.log(val)
        let row = document.createElement("tr")
        let col1 = document.createElement("td")
        let col2 = document.createElement("td")
        let col3 = document.createElement("td")
        let col4 = document.createElement("td")
        let col5 = document.createElement("td")
        let col6 = document.createElement("td")
        let col7 = document.createElement("td")
        col1.textContent = val[2]
        col2.textContent = val[6]
        col3.textContent = val[3]
        col4.textContent = val[1]
        col5.textContent = val[0]
        col6.textContent = val[5]
        col7.textContent = val[4]
        row.appendChild(col1)
        row.appendChild(col2)
        row.appendChild(col3)
        row.appendChild(col4)
        row.appendChild(col5)
        row.appendChild(col6)
        row.appendChild(col7)
        d.append(row)
        console.log(row)
    })

}))