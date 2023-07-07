import { useState } from 'react';
import './App.css'
import { Card } from './components/Card';
import { useFoodData } from './hooks/useFoodData';
import { FoodData } from './interface/FoodData';
import { CreateModal } from './components/CreateModal';

function App() {
  const { data } = useFoodData();
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(prev => !prev)
  }

  return (
      <div className="container">
        <h1>Cardapio</h1>
        <div className='card-grid'>
          {data?.map(foodData => 
            <Card 
              price={foodData.price} 
              title={foodData.title} 
              image={foodData.image} 
            />)}
        </div>
        {isModalOpen && <CreateModal closeModal={handleOpenModal}/>}
        <button onClick={handleOpenModal}>Adicionar</button>
      </div>
  )
}

export default App
