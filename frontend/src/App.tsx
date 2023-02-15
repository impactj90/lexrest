import {useEffect, useState} from 'react'
import './App.css'
import axios from 'axios';
import {ProductModel} from "./components/product/Product";
import {ProductList} from "./components/product/ProductList";
import useDebounce from "./hooks/useDebounce";

function App() {
    const [products, setProducts] = useState<Array<ProductModel>>([]);
    const [eanNumber, setEanNumber] = useState<string>('');
    const debouncedValue = useDebounce(eanNumber, 1000);

    useEffect(() => {
        const cancelToken = axios.CancelToken.source();
            axios.get(`http://localhost:8080/api/v1/products/ean/${eanNumber}`, {
                cancelToken: cancelToken.token
            })
                .then((response) => {
                        setProducts(prevState => [response.data]);
                    }
                ).catch((error) => {
                    if (axios.isCancel(error)) {
                        console.log('Aborted');
                    } else {
                        console.log(error);
                    }
                }
            );
        return () => {
            cancelToken.cancel();
        }
    }, [debouncedValue]);

    const handleFindProductByEAN = (event: React.ChangeEvent<HTMLInputElement>) => {
        setEanNumber(event.target.value);
    }
    return (
        <div className="App">
            <input className={'searchBar'} type={'search'} placeholder={'Search EAN...'}
            onChange={handleFindProductByEAN}/>
            <ProductList products={products}/>
        </div>
    )
}

export default App