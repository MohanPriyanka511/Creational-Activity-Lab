<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food World: AP</title>
    <link rel="stylesheet" href="styles.css">
    
</head>
<body>
    <nav>
        <p>Food World: AP</p>
        <ul>
            <li><a href="#Insert">Insert New Record</a></li>
            <li><a href="#Display">Display New Record</a></li>
            <li><a href="#Update">Update Record</a></li>
            <li><a href="#Delete">Delete Record</a></li>
        </ul>
    </nav>
    <hr>
    <div>
        <section id="Insert">
            <h1>Insert New Food Record</h1>
            <form action="http://localhost:8080/CAL02/Myservlet">
                <input style="display: none;" type="text" name="ch" value="1">
                <div>
                    <div><label for="name">Enter Food Name:</label><span>*</span></div>
                    <div><input required type="text" name="name" id="name"></div>
                </div>
                <div>
                    <div><label for="price">Enter Food Price:</label><span>*</span></div>
                    <div><input required type="number" name="price" id="price"></div>
                </div>
                <div>
                    <div>
                        <label>
                            <p>Enter Food categary:<span>*</span></p>
                        </label>
                    </div>
                    <div>
                        <input required type="radio" name="categary" id="veg" value="veg"> <label
                            for="veg">Vegetarioun</label>
                        <input required type="radio" name="categary" id="non-veg" value="non-veg"> <label
                            for="non-veg">Non-Vegetarioun</label>
                    </div>
                </div>
                <button>Submit</button>
            </form>
        </section>
        <section id="Display">
            <h1>Food Record</h1>
            <table border="1">
                <tr>
                    <th>Sr. No.</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Categary</th>
                </tr>
            </table>
        </section>
        <section id="Update">
            <h1>Update Food Record</h1>
            <form action="http://localhost:8080/CAL02/Myservlet">
                <input style="display: none;" type="text" name="ch" value="3">

                <div>
                    <div>
                        <label for="foodid">Enter Food ID:</label>
                    </div>
                    <div>
                        <input type="number" name="foodid" id="foodid">
                    </div>
                </div>

                <div>
                    <div>
                        <label for="newname">Enter New Name:</label>
                    </div>
                    <div>
                        <input type="text" name="foodnameNew" id="newname">
                    </div>
                </div>

                <div>m
                    <div>
                        <label for="foodprice">Enter New Price:</label>
                    </div>
                    <div>
                        <input type="number" name="foodpriceNew" id="foodprice" value="0">
                    </div>
                </div>

                <div>
                    <div>
                        <p>Enter New categary: </p>
                    </div>
                    <div>
                        <input type="radio" name="foodnewcat" id="newveg" value="veg"> <label
                            for="newveg">Vegetarioun</label>
                        <input type="radio" name="foodnewcat" id="newnon-veg" value="non-veg"> <label
                            for="newnon-veg">Non-Vegetarioun</label>
                    </div>
                </div>

                <button>Submit</button>

            </form>
        </section>
        <section id="Delete">
            <h1>Delete Food Record</h1>
            <form action="http://localhost:8080/CAL02/Myservlet">
                <input style="display: none;" type="text" name="ch" value="4">
                <div>
                    <div>
                        <label for="foodidDelete">Enter Food ID:</label>
                    </div>
                    <div>
                        <input type="number" name="foodIDDel" id="foodidDelete">
                    </div>
                </div>
                <button>Submit</button>
            </form>
        </section>
    </div>
    <script>
        fetch("http://localhost:8080/CAL02/Myservlet?ch=2").then((e) => e.json().then((data) => {
            // console.log(data)
            let foodData = Object.values(data)
            // console.log(foodData)
            foodData.forEach((e) => {
                console.log(e.id)


                let tablerow = document.createElement("tr")

                let srno = document.createElement("td")
                srno.textContent = e.id;
                tablerow.appendChild(srno)

                let name = document.createElement("td")
                name.textContent = e.FoodName;
                tablerow.appendChild(name)

                let price = document.createElement("td")
                price.textContent = e.FoodPrice;
                tablerow.appendChild(price)

                let cat = document.createElement("td")
                cat.textContent = e.FoodCategary;
                tablerow.appendChild(cat)

                document.querySelector("table").appendChild(tablerow)
            })
        }))
    </script>
</body>
</html>